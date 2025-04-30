let questions = [];
let selectedAnswers = [];
let timerInterval;
let timeLeft = 60;

async function loadQuestions() {
  document.getElementById('quiz-image').style.display = 'none';

  const category = document.getElementById('category-select').value;
  const response = await fetch(`http://localhost:8080/api/questions?category=${category}`);
  questions = await response.json();

  const quizContainer = document.getElementById('quiz-container');
  quizContainer.innerHTML = '';
  selectedAnswers = [];

  questions.forEach((question, index) => {
    const questionDiv = document.createElement('div');
    questionDiv.classList.add('question');

    const questionTitle = document.createElement('h3');
    questionTitle.textContent = question.question;
    questionDiv.appendChild(questionTitle);

    question.answers.forEach((answer, answerIndex) => {
      const label = document.createElement('label');
      label.id = `q${index}a${answerIndex}`;

      const radio = document.createElement('input');
      radio.type = 'radio';
      radio.name = `question${index}`;
      radio.value = answerIndex;
      radio.onclick = () => selectedAnswers[index] = answerIndex;

      label.appendChild(radio);
      label.appendChild(document.createTextNode(answer));
      questionDiv.appendChild(label);
      questionDiv.appendChild(document.createElement('br'));
    });

    quizContainer.appendChild(questionDiv);
  });

  document.getElementById('finish-button').style.display = 'inline-block';
  document.getElementById('timer-section').style.display = 'block';

  startTimer(); 
}

function showResult() {
  clearInterval(timerInterval);
  let correctCount = 0;

  questions.forEach((question, index) => {
    const userAnswer = selectedAnswers[index];
    const correctAnswer = question.correctIndex;

    question.answers.forEach((_, answerIndex) => {
      const label = document.getElementById(`q${index}a${answerIndex}`);
      if (answerIndex === correctAnswer) {
        label.style.color = 'green';
      }
      if (userAnswer === answerIndex && userAnswer !== correctAnswer) {
        label.style.color = 'red';
      }
    });

    if (userAnswer === correctAnswer) {
      correctCount++;
    }
  });

  const resultDiv = document.getElementById('result');
  resultDiv.textContent = `Du hast ${correctCount} von ${questions.length} Fragen richtig beantwortet! 🎉`;
}

function startTimer() {
  clearInterval(timerInterval);
  timeLeft = 60;

  const progressBar = document.getElementById('progress-bar');
  const timerDisplay = document.getElementById('timer');
  timerDisplay.textContent = `Verbleibende Zeit: ${timeLeft} Sekunden`;

  timerInterval = setInterval(() => {
    timeLeft--;

    timerDisplay.textContent = `Verbleibende Zeit: ${timeLeft} Sekunden`;

    const percentage = (timeLeft / 60) * 100;
    progressBar.style.width = `${percentage}%`;

    if (timeLeft <= 10) {
      progressBar.style.backgroundColor = 'red';
    } else if (timeLeft <= 30) {
      progressBar.style.backgroundColor = 'orange';
    } else {
      progressBar.style.backgroundColor = '#4caf50';
    }

    if (timeLeft <= 0) {
      clearInterval(timerInterval);
      showResult();
    }
  }, 1000);
}