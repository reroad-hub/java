package AddressProject.AddressProject.src;

import java.util.Scanner;

public class AddressManager {
    private User[] userList = new User[3];
    User currentUser;

    public AddressManager(){
        this.userList[0] = new User("aaa","aa","11", "55555555", "서울");
        this.userList[1] = new User("bbb","bb","22", "77777777", "경기");
        this.userList[2] = new User("ccc","cc","33", "88888888", "부산");
    }

    public void run(){
        while(true){
            boolean endFlag = false;
            MenuManager.initMenu();
            int select = MenuManager.selectInitMenu();
            switch (select){
                case MenuManager.LOGIN:
                    if(this.login()){
                        this.addressProcess();
                    }
                    break;
                case MenuManager.EXIT:
                    endFlag = true;
                    break;
            }
            if(endFlag){
                break;
            }
        }
    }

    public boolean login(){
        Scanner input = new Scanner(System.in);
        System.out.print("ID : ");
        String id = input.nextLine();
        System.out.print("PW : ");
        String pw = input.nextLine();

        for(int i=0; i<this.userList.length; i++){
            if(this.userList[i].getId().equals(id)){
                if(this.userList[i].getPw().equals(pw)){
                    System.out.println("로그인 성공");
                    this.currentUser = this.userList[i];
                    return true;
                }
            }
        }

        System.out.println("계정정보가 틀렸습니다.");
        return false;
    }

    public void addressProcess(){
        while(true){
            boolean endFlag = false;
            MenuManager.addressMenu();
            int select = MenuManager.selectAddressMenu();
            switch (select){
                case MenuManager.ADDRESS_SEARCH:
                    this.addressSearch();
                    break;
                case MenuManager.ADDRESS_SEARCH_ALL:
                    this.addressSearchAll();
                    break;
                case MenuManager.USER_INFO_UPDATE:
                    this.userInfoUpdate();
                    break;
                case MenuManager.LOGOUT:
                    endFlag = true;
                    this.currentUser = null;
            }
            if(endFlag){
                break;
            }
        }
    }

    public void addressSearch(){
        Scanner input = new Scanner(System.in);
        System.out.println("검색할 사용자 이름:");
        String name = input.nextLine();

        for(int i=0; i<this.userList.length; i++){
            if(userList[i].getName().equals(name)){
                System.out.println(this.userList[i].getName() + "님의 주소: " + this.userList[i].getAddress());
                System.out.println(this.userList[i].getName() + "님의 전화번호: " + this.userList[i].getPhone());
            }
        }
    }

    public void addressSearchAll() {
        for (int i = 0; i < this.userList.length; i++) {
            System.out.println(this.userList[i].getName() + "님의 주소: " + this.userList[i].getAddress());
            System.out.println(this.userList[i].getName() + "님의 전화번호: " + this.userList[i].getPhone());
        }
    }
    public void userInfoUpdate(){
        Scanner input = new Scanner(System.in);
        System.out.println("PW :");
        String pw = input.nextLine();

        if(!this.currentUser.getPw().equals(pw)){
            System.out.println("비밀번호가 틀렸습니다.");
            return;
        }

        System.out.print("Phone");
        String phone = input.nextLine();
        System.out.print("Address");
        String address = input.nextLine();

        this.currentUser.setAddress(address);
        this.currentUser.setPhone(phone);
        System.out.println(this.currentUser.getName() + "님의 정보가 변경되었습니다.");
    }
}
