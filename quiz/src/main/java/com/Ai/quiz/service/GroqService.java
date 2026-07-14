    package com.Ai.quiz.service;

    import com.Ai.quiz.entity.Question;
    import org.springframework.stereotype.Service;

    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.ArrayList;
    import java.util.List;
    import org.springframework.beans.factory.annotation.Value;

    @Service
    public class GroqService {

        @Value("${groq.api.key}")
        private String API_KEY;

        @Value("${groq.model}")
        private String MODEL;

        public List<Question> generateQuiz(String topic) {

            try {
                String prompt =
                        "Generate exactly 3 beginner-level Java multiple-choice questions about " + topic + ".\n\n" +

                                "Return ONLY this format:\n\n" +

                                "Q: Question\n" +
                                "A: Option A\n" +
                                "B: Option B\n" +
                                "C: Option C\n" +
                                "D: Option D\n" +
                                "ANSWER: A\n" +
                                "REASON: Short explanation\n\n" +

                                "Do not use markdown.\n" +
                                "Do not use numbering.\n" +
                                "Do not write anything except the above format.";

                String body =
                        "{"
                                + "\"model\":\"" + MODEL + "\","
                                + "\"messages\":[{"
                                + "\"role\":\"user\","
                                + "\"content\":\"" + prompt.replace("\n","\\n") + "\""
                                + "}]"
                                + "}";

                HttpRequest request = HttpRequest.newBuilder()

                        .uri(URI.create("https://api.groq.com/openai/v1/chat/completions"))

                        .header("Content-Type","application/json")

                        .header("Authorization","Bearer "+API_KEY)

                        .POST(HttpRequest.BodyPublishers.ofString(body))

                        .build();

                HttpClient client = HttpClient.newHttpClient();

                HttpResponse<String> response =
                        client.send(request,HttpResponse.BodyHandlers.ofString());

                String text = extract(response.body());

                return parse(text);

            }

            catch (Exception e){

                return demoQuiz();

            }

        }

        private String extract(String json){

            String key="\"content\"";

            int start=json.indexOf(key);

            start=json.indexOf("\"",json.indexOf(":",start))+1;

            StringBuilder sb=new StringBuilder();

            boolean slash=false;

            for(int i=start;i<json.length();i++){

                char c=json.charAt(i);

                if(slash){

                    if(c=='n')
                        sb.append("\n");
                    else
                        sb.append(c);

                    slash=false;

                }

                else if(c=='\\')
                    slash=true;

                else if(c=='"')
                    break;

                else
                    sb.append(c);

            }

            return sb.toString();

        }

        private List<Question> parse(String quiz){

            List<Question> list = new ArrayList<>();

            String[] lines = quiz.replace("\r","").split("\n");

            Question q = null;

            for(String line : lines){

                line = line.trim();

                if(line.startsWith("Q:")){

                    if(q != null)
                        list.add(q);

                    q = new Question();

                    q.setQuestion(line.substring(2).trim());

                }

                else if(line.startsWith("A:"))
                    q.setOptionA(line.substring(2).trim());

                else if(line.startsWith("B:"))
                    q.setOptionB(line.substring(2).trim());

                else if(line.startsWith("C:"))
                    q.setOptionC(line.substring(2).trim());

                else if(line.startsWith("D:"))
                    q.setOptionD(line.substring(2).trim());

                else if(line.startsWith("ANSWER:"))
                    q.setAnswer(line.substring(7).trim());

                else if(line.startsWith("REASON:"))
                    q.setReason(line.substring(7).trim());

            }   // <-- for loop ends here

            if(q != null)
                list.add(q);

            for(Question q1 : list){

                if(q1.getReason() == null || q1.getReason().isBlank()){

                    q1.setReason("No explanation available.");

                }

            }

            return list;

        }

        private List<Question> demoQuiz() {

            List<Question> list = new ArrayList<>();

            list.add(new Question(
                    "What is JVM?",
                    "Java Virtual Machine",
                    "Java Version",
                    "Java Variable",
                    "Java Vendor",
                    "A",
                    "JVM stands for Java Virtual Machine. It is responsible for running Java bytecode."
            ));

            list.add(new Question(
                    "Which loop repeats code?",
                    "if",
                    "for",
                    "switch",
                    "class",
                    "B",
                    "The for loop is used to execute a block of code repeatedly."
            ));

            list.add(new Question(
                    "Which datatype stores true or false?",
                    "String",
                    "boolean",
                    "int",
                    "double",
                    "B",
                    "The boolean data type can store only true or false values."
            ));
            return list;
        }

    }