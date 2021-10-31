package util.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSample {

    public static void main(String[] args) throws ParseException {
        String jsonStr = "{ \"date\":\"2021-10-31\", \"member\":[{ \"memberId\":\"0003\", \"memberName\":\"김사원\", \"memberTel\":\"010-0003-0003\" }, { \"memberId\":\"0001\", \"memberName\":\"최대리\", \"memberTel\":\"010-0001-0001\" }, { \"memberId\":\"0005\", \"memberName\":\"곽주임\", \"memberTel\":\"010-0005-0005\" }, { \"memberId\":\"0004\", \"memberName\":\"장부장\", \"memberTel\":\"010-0004-0004\" }, { \"memberId\":\"0006\", \"memberName\":\"홍과장\", \"memberTel\":\"010-0006-0006\" }, { \"memberId\":\"0002\", \"memberName\":\"오차장\", \"memberTel\":\"010-0002-0002\" }]}\n";

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonStr);
        JSONObject jsonObject = (JSONObject) obj;
        String date = (String) jsonObject.get("date");
        System.out.println("DATE:" + date);

        JSONArray memberArr = (JSONArray) jsonObject.get("member");
        JSONObject memberObj = null;
        for (int i = 0; i < memberArr.size(); i++) {
            memberObj = (JSONObject) memberArr.get(i);
            System.out.println("ID:" + memberObj.get("memberId")
                    + ", NAME:" + memberObj.get("memberName")
                    + ", TEL:" + memberObj.get("memberTel"));
        }

        /*
            ---------------------------------------------
            ------------------ console ------------------
            ---------------------------------------------
            DATE:2021-10-31
            ID:0003, NAME:김사원, TEL:010-0003-0003
            ID:0001, NAME:최대리, TEL:010-0001-0001
            ID:0005, NAME:곽주임, TEL:010-0005-0005
            ID:0004, NAME:장부장, TEL:010-0004-0004
            ID:0006, NAME:홍과장, TEL:010-0006-0006
            ID:0002, NAME:오차장, TEL:010-0002-0002
         */
    }

}
