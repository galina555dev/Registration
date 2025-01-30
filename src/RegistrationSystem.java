import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationSystem implements Serializable {
    private String filename;
    private List<User> users=new ArrayList<>();

    /*public RegistrationSystem(String filename, List<User> users) {
        this.filename = filename;
        this.users = users;
    }*/
    public RegistrationSystem(String fileName) {
        this.filename = fileName;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            List<User> users = (List<User>)objectInputStream.readObject();
            setUsers(users);

        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public String toString() {
        return "RegistrationSystem{" +
                "users=" + users +
                '}';
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;

    }
    	public User login(String nickname, String password) {
            for(int i=0; i<users.size(); i++) {
                String localNickname = users.get(i).getNickname();
                String localPassword = users.get(i).getPassword();
                if (localNickname.equals(nickname) && localPassword.equals(password)) {
                    return users.get(i);
                }
            }
                 return null;

    }// - принимает на вход какой-то логин и пароль. Если существует юзер с такими данными, то возвращает его, иначе возвращает null.
            	public boolean register(String nickname, String password) {
                    for(int i=0; i<users.size(); i++) {
                        String localNickname = users.get(i).getNickname();
                        String localPassword = users.get(i).getPassword();
                        if (localNickname.equals(nickname)||localPassword.equals(password) ) {
                            System.out.println("Пользователь уже есть");

                            return false;
                        }
                        }
                        users.add(new User(nickname,password,new Date()));
                    return true;
                }//– принимает на вход логин с паролем. Если уже существует юзер с таким именем, то возвращает false. Иначе, создается новый пользователь с этими данными и кладётся в список и возвращается true.
            	public void saveData(){
                    try(ObjectOutputStream objectOutputStream  = new ObjectOutputStream(
                            new FileOutputStream(this.filename))){
                        objectOutputStream.writeObject(this.users);
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
}

                //– метод, который будет сохранять содержимое списка users в файл, имя которого было передано в конструкторе.


