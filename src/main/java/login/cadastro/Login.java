package login.cadastro;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Login {

    private final LoginRepository loginRepository;

    public Login(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return loginRepository.save(cliente);
    }

    public Cliente buscarPorEmail(String email) {
        return loginRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    public Cliente buscarPorNome(String nome) {
        return loginRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }

    public List<Cliente> buscarPorIdade(Integer idade) {
        return loginRepository.findByIdade(idade);
    }

    public void deletarPorNome(String nome) {
        Cliente cliente = buscarPorNome(nome);
        loginRepository.delete(cliente);
    }

    public void deletarPorIdade(Integer idade) {
        loginRepository.deleteAll(loginRepository.findByIdade(idade));
    }
}
