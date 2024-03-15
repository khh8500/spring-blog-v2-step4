package shop.mtcoding.blog.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class) // IoC 등록코드
@DataJpaTest // Datasource(connection pool), EntityManger
public class UserRepositoryTest {
    @Autowired // DI
    private UserRepository userRepository;

    @Test
    public void findByUsernameAndPassword_test() {
        // given
        String username = "ssar";
        String password = "1234";

        // when
        User user = userRepository.findByUsernameAndPassword(username, password);

        // then
        Assertions.assertThat(user.getUsername()).isEqualTo("ssar");
        Assertions.assertThat(user.getPassword()).isEqualTo("1234");
    }
}
