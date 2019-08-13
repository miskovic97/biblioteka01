package biblioteka.service;

import java.util.List;
import java.util.Optional;

import biblioteka.model.SystemRole;

public interface SystemRoleService {
	List<SystemRole> getAll();
	Optional<SystemRole> getByname(String name);
	SystemRole save(SystemRole systemRole);
	SystemRole update(SystemRole systemRole,String name);
	void delete(String name);
}
