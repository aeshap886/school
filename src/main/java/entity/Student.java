package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String fullName;
    
    private String role;

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    

    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String username, String fullName, String role, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student admin = (Student) o;
        return Objects.equals(id, admin.id) &&
               Objects.equals(username, admin.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
