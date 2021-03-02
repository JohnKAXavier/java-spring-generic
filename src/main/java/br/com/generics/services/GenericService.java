package br.com.generics.services;

import br.com.generics.dto.EmployeeDTO;
import br.com.generics.entities.Employee;
import br.com.generics.repositories.EmployeeRepository;
import br.com.generics.util.Convertible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface GenericService<T extends Convertible<DTO>, DTO, ID> {

	JpaRepository<T, ID> getRepository();
	
	default DTO findById(ID id) {
		Optional<T> result = getRepository().findById(id);
		return result.get().convert();
	}

    default List<DTO> findAll() {
		List<T> employeeList = getRepository().findAll();
		return employeeList.stream().map(employee -> employee.convert()).collect(Collectors.toList());
    }
}
