import speech_recognition
import pyttsx3

def voice_to_text():
    recognizer = speech_recognition.Recognizer()
    
    while True:
        try:
            with speech_recognition.Microphone() as mic:
                recognizer.adjust_for_ambient_noise(mic, duration=0.5)
                audio = recognizer.listen(mic, timeout=4)
                text = recognizer.recognize_google(audio, language= 'en-US', show_all=False)
                print(str(text))

        except speech_recognition.UnknownValueError():
            break

def main():
    voice_to_text()

if __name__ == "__main__":
    main()