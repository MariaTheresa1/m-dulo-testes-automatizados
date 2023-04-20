package com.ada.aulatdd;

import com.ada.aulamockito.repository.ProdutoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProdutoRepository produtoRepository;

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Before
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/produtos";
    }

    @After
    public void tearDown() {
        produtoRepository.deleteAll();
    }

    @Test
    public void listarProdutosDeveRetornarListaDeProdutos() {
        // given
        Produto produto1 = new Produto("Produto 1", "Descrição do Produto 1", BigDecimal.valueOf(10.0));
        Produto produto2 = new Produto("Produto 2", "Descrição do Produto 2", BigDecimal.valueOf(20.0));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2));

        // when
        ResponseEntity<List<Produto>> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Produto>>() {});

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Produto> produtos = response.getBody();
        assertEquals(2, produtos.size());
        assertEquals(produto1.getNome(), produtos.get(0).getNome());
        assertEquals(produto2.getNome(), produtos.get(1).getNome());
    }

    @Test
    public void buscarProdutoPorIdDeveRetornarProdutoCorreto() {
        // given
        Produto produto1 = new Produto("Produto 1", "Descrição do Produto 1", BigDecimal.valueOf(10.0));
        produtoRepository.save(produto1);

        // when
        ResponseEntity<Produto> response = restTemplate.getForEntity(baseUrl + "/" + produto1.getId(), Produto.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Produto produto = response.getBody();
        assertEquals(produto1.getNome(), produto.getNome());
    }

    @Test
    public void criarProdutoDeveCriarNovoProduto() {
        // given
        Produto produto = new Produto("Produto 1", "Descrição do Produto 1", BigDecimal.valueOf(10.0));
        HttpEntity<Produto> request = new HttpEntity<>(produto);

        // when
        ResponseEntity<Produto> response = restTemplate.postForEntity(baseUrl, request, Produto.class);

        // then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Produto produtoSalvo = produtoRepository.findById(response.getBody().getId()).orElse(null);
        assertNotNull(produtoSalvo);
        assertEquals(produto.getNome(), produtoSalvo.getNome());
    }

    @Test
    public void atualizarProdutoDeveAtualizarProdutoExistente() {
        // given
        Produto produto = new Produto("Produto 1", "Descrição do Produto 1", BigDecimal.valueOf(10.0));
        produtoRepository.save(produto);

        Produto produtoAtualizado = new Produto("Produto 2", "Descrição do Produto 2", BigDecimal.valueOf(20.0));
        HttpEntity<Produto> request = new HttpEntity<>(produtoAtualizado);

        // when
        ResponseEntity<Produto> response = restTemplate.exchange(baseUrl + "/" + produto.getId(), HttpMethod.PUT, request, Produto.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Produto produtoSalvo = produtoRepository.findById(produto.getId()).orElse(null);
        assertNotNull(produtoSalvo);
        assertEquals(produtoAtualizado.getNome(), produtoSalvo.getNome());
        assertEquals(produtoAtualizado.getDescricao(), produtoSalvo.getDescricao());
        assertEquals(produtoAtualizado.getPreco(), produtoSalvo.getPreco());
    }

    @Test
    public void excluirProdutoDeveExcluirProdutoExistente() {
        // given
        Produto produto = new Produto("Produto 1", "Descrição do Produto 1", BigDecimal.valueOf(10.0));
        produtoRepository.save(produto);

        // when
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/" + produto.getId(), HttpMethod.DELETE, null, Void.class);

        // then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(produtoRepository.findById(produto.getId()).orElse(null));
    }
}