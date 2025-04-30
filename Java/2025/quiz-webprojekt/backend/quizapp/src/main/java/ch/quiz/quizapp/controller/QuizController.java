package ch.quiz.quizapp.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import ch.quiz.quizapp.model.Question;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class QuizController {

    @GetMapping("/questions")
    public List<Question> getQuestionsByCategory(@RequestParam String category) {
        List<Question> allQuestions = List.of(
                new Question(
                        "Was ist die Hauptstadt der USA?",
                        List.of("Washington D.C.", "New York", "Los Angeles", "Chicago"),
                        0,
                        "Geografie"
                ),
                new Question(
                        "Wer ist der GOAT von Fussball?",
                        List.of("Cristiano Ronaldo", "Lionel Messi", "Pele", "Diego Maradona"),
                        1,
                        "Sport"
                ),
                new Question(
                        "Wie gross ist der Mount Everest?",
                        List.of("8848 Meter", "8000 Meter", "9000 Meter", "8500 Meter"),
                        0,
                        "Geografie"
                ),
                new Question(
                        "Wer hält den Weltrekord im 100-Meter-Lauf?",
                        List.of("Mo Farah", "Carl Lewis", "Jesse Owens", "Usain Bolt"),
                        3,
                        "Sport"
                ),
                new Question(
                        "Wie viele Kontinente gibt es auf der Erde?",
                        List.of("5", "6", "7", "8"),
                        2,
                        "Geografie"
                ),
                new Question(
                        "Wer hat die meisten Tore in der Geschichte der Fussball-Weltmeisterschaft erzielt?",
                        List.of("Pele", "Ronaldo", "Gerd Müller", "Diego Maradona"),
                        0,
                        "Sport"
                ),
                new Question(
                        "Wie heisst der Hauptcharakter, gespielt von Vin Diesel?",
                        List.of("Dom Toretto", "Brian O'Conner", "Luke Hobbs", "Deckard Shaw"),
                        0,
                        "Film"
                ),
                new Question(
                        "Wie heisst der Onkel von Simba im Film Der König der Löwen?",
                        List.of("Mufasa", "Scar", "Rafiki", "Zazu"),
                        1,
                        "Film"
                ),
                new Question(
                        "Wie heisst der Hauptcharakter in Prison Break, der absichtlich ins Gefängnis geht, um seinen Bruder zu befreien?",
                        List.of("Sucre", "Lincoln Burrows", "T-Bag", "Michael Scofield"),
                        3,
                        "Film"
                )
        );
        return allQuestions.stream()
                .filter(q -> q.getCategory().equalsIgnoreCase(category))
                .toList();
    }
}
