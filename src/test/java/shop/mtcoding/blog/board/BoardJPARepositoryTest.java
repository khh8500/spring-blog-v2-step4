package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import shop.mtcoding.blog.user.User;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class BoardJPARepositoryTest {

    @Autowired
    private BoardJAPRepository boardJAPRepository;

    @Autowired
    private EntityManager em;

    // save
    @Test
    public void save_test() {
        // given
        User sessionUser = User.builder().id(1).build();
        Board board = Board.builder()
                .title("제목5")
                .content("내용")
                .user(sessionUser)
                .build();

        // when
        boardJAPRepository.save(board);

        // then
        System.out.println("save_test : id : "+board.getUser());
    }

    // findById
    @Test
    public void findById_test(){
        // given
        int id = 1;

        // when
        Optional<Board> boardOP = boardJAPRepository.findById(id);

        if(boardOP.isPresent()){
            Board board = boardOP.get();
            System.out.println("findByID_test : "+board.getTitle());
        }
        // then
    }
    // findByIdjoinUser
    @Test
    public void findByIdJoinUser_test(){
        // given
        int id = 1;

        // when
        Board board = boardJAPRepository.findByIdJoinUser(id);

        // then
        System.out.println("findByIdJoinUser_test : "+board.getTitle());
        System.out.println("findByIdJoinUser_test : "+board.getUser());
    }
    // findAll
    @Test
    public void findAll_test(){
        // given
        Sort sort = Sort.by(Sort.Direction.DESC, "id");


        // when
        List<Board> boardList = boardJAPRepository.findAll(sort);

        // then
        System.out.println("findAll_test : "+boardList);
    }
    // deleteById
    @Test
    public void deleteById_test(){
        // given
        int id = 1;

        // when
        boardJAPRepository.deleteById(id);
        em.flush();

        // then
    }
}
