package one.digitalinnovation.beerstock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.beerstock.exception.BeerNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages beer stock")
public interface BeerControllerDocs {

    @ApiOperation(value = "Operação de criação de cerveja")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cerveja criada com sucesso."),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes ou valor de intervalo de campo incorreto.")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Retorna cerveja encontrada, por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso, cerveja encontrada no sistema"),
            @ApiResponse(code = 404, message = "Cerveja com o nome informado não encontrada.")
    })
    BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException;

    @ApiOperation(value = "Retorna uma lista de todas as cervejas cadastradas no sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de todas as cervejas cadastradas no sistema"),
    })
    List<BeerDTO> listBeers();

    @ApiOperation(value = "Excluir uma cerveja encontrada por determinado ID válido")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Cerveja excluida com sucesso."),
            @ApiResponse(code = 404, message = "Cerveja com id fornecida não encontrada.")
    })
    void deleteById(@PathVariable Long id) throws BeerNotFoundException;
}
