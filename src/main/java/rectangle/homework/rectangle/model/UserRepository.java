/*
 * AUTHOR: Asheesh Yadav
 * DESCRIPTION: This class is the model for the users making the rectangles
 * DATE: 6/09/2024
 *
 */
package rectangle.homework.rectangle.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//This class is the repository for the users making the rectangles
public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByName(String name);
}
