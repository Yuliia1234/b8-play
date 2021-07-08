package utils;

public class PayloadUtils {

    public static String getSlackMassagePayload(String massage, String chanelID) {

        return "{\n" +
                "    \"text\":\"" + massage + "\",\n" +
                "    \"channel\":\"" + chanelID + "\"\n" +
                "}";
    }

    public static String getPayload(int petId, String petName, String petStatus) {
        String requesBody = "{\n" +
                "    \"id\": 9000,\n" +
                "    \"category\": {\n" +
                "        \"id\": 700\n" +
                "    },\n" +
                "    \"name\": \"Doggy\",\n" +
                "    \"photoUrls\": [],\n" +
                "    \"tags\": [],\n" +
                "    \"status\": \"java code\"\n" +
                "}";
        return requesBody;
    }

    public static String sendComment(int postId, String name, String email, String body) {
        String post = "        {\n" +
                "            \"id\"" + postId + "\n" +
                "            \"post_id\": 2,\n" +
                "            \"name\": \"" + name + "\",\n" +
                "            \"email\": \"" + email + "\",\n" +
                "            \"body\": \"" + body + "\"" + "}";

        return post;
    }
}
