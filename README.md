# AYQYN JARVIS MOBILE — API edition

Android project in Kotlin + Jetpack Compose. No Ollama required.

## How it works
Android app → your HTTPS `/chat` backend → OpenAI API. The secret API key stays on the backend, **not** in the APK. The included `api_server/server.py` is a **local development example**, not a secure public service.

## Setup
1. Open the project folder in Android Studio, install required SDK components, and build/run.
2. Obtain an OpenAI API key from your own account (API usage is billed separately). Do not send it in chat or put it in Android source.
3. On your backend machine, set the `OPENAI_API_KEY` environment variable and run `python api_server/server.py`.
4. To connect from a phone over the internet, deploy the backend behind HTTPS with **client authentication, rate limits, and request quotas**. Do not expose the included unauthenticated development server publicly.
5. In the app settings, enter your HTTPS backend URL (without `/chat`). The app POSTs `{ "messages": [...] }` and expects `{ "answer": "..." }`.

The backend chooses the model using `AYQYN_MODEL` (default `gpt-4.1-mini`). The app's model field is currently informational and not used to select a model on the backend, to avoid unrestricted client-driven costs.

## Current limitations
- No ready-built APK, no Android build verification in this environment.
- Voice recognition requires Android speech services; offline availability varies by device.
- Always-on wake word, background automation, long-term memory, and standalone offline AI are **not yet implemented**.
- The sample proxy has no login/authentication and listens only on localhost. Do not publish it as-is.
- AI responses require internet access and available API credit.
