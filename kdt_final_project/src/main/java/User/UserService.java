package User;

public interface UserService{
	
   public void signup(UserDTO dto);
   public UserDTO login(String userid, String userpw);

}
