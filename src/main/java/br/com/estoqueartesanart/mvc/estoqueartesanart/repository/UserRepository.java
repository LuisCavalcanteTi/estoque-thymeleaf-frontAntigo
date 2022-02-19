package br.com.estoqueartesanart.mvc.estoqueartesanart.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoqueartesanart.mvc.estoqueartesanart.model.User;




@Repository
public interface UserRepository  extends JpaRepository <User, String>{

	User findByUsername(String Username);
	
	
	

	

	
	

}
