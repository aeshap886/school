package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exampl.repository.AdminRepository;
import com.exampl.repository.StudentRepository;

import entity.Student;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
   
	@Service
	public class CustomLoginDetailsService implements UserDetailsService {

	    @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            return new User(
                    student.getUsername(),
                    student.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(student.getRole()))
            );
        }

       

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
