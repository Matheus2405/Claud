package login.cadastro;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class Controler {

    private final Login login;

    public Controler(Login login) {
        this.login = login;
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return login.salvar(cliente);
    }

    @GetMapping("/email")
    public Cliente buscarPorEmail(@RequestParam String email) {
        return login.buscarPorEmail(email);
    }

    @GetMapping("/nome")
    public Cliente buscarPorNome(@RequestParam String nome) {
        return login.buscarPorNome(nome);
    }

    @GetMapping("/idade")
    public List<Cliente> buscarPorIdade(@RequestParam Integer idade) {
        return login.buscarPorIdade(idade);
    }

    @DeleteMapping("/nome")
    public String deletarPorNome(@RequestParam String nome) {
        login.deletarPorNome(nome);
        return "Cliente deletado com sucesso";
    }

    @DeleteMapping("/idade")
    public String deletarPorIdade(@RequestParam Integer idade) {
        login.deletarPorIdade(idade);
        return "Clientes deletados com sucesso";
    }
}
