package basic.clazz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Player {

    int age;
    String name;

    public Player() {
    }

    public Player(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class ObjectMapperEx {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "";


        /*
            List<Object> -> List<Map>
         */
        // 데이터 생성
        List<Player> players = new ArrayList<>();
        makeData(players);
        System.out.println(players); // [choi(31), lee(20), kim(22), park(40)]

        // 데이터 변환
        List<Map<String, Object>> playerList = new ArrayList<>();
        for (Player player : players) {
            HashMap<String, Object> map = objectMapper.convertValue(player, HashMap.class);
            playerList.add(map);
        }
        System.out.println(playerList); // [{name=choi, age=31}, {name=lee, age=20}, {name=kim, age=22}, {name=park, age=40}]



        /*
            JSON -> Object
         */
        // 데이터 변환
        jsonStr = "{ \"name\" : \"choi\" , \"age\" : 31 }";
        Player player = objectMapper.readValue(jsonStr, Player.class);
        System.out.println(player); // choi(31)



        /*
            JSON -> List<Object>
         */
        // 데이터 변환
        jsonStr = "[{\"age\" : 31 , \"name\" : \"choi\"} , {\"age\" : 20 , \"name\" : \"lee\"} , {\"age\" : 22 , \"name\" : \"kim\"} , {\"age\" : 40 , \"name\" : \"park\"}]";
        List<Player> players2 = objectMapper.readValue(jsonStr, new TypeReference<List<Player>>() {});
        System.out.println(players2); // [choi(31), lee(20), kim(22), park(40)]
    }

    public static void makeData(List<Player> players){
        players.add(new Player(31, "choi"));
        players.add(new Player(20, "lee"));
        players.add(new Player(22, "kim"));
        players.add(new Player(40, "park"));
    }

}
