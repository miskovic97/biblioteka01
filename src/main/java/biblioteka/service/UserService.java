package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.User;

public interface UserService {
	List<User> getAll();

	Optional<User> getByuserid();

	User save(User user);

	User update(User user, long id);

	void delet(long id);
}
