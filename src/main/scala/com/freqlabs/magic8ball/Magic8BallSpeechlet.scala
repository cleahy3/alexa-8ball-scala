/*
 * Copyright (c) 2016 Ryan Moeller <ryan@freqlabs.com>
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED “AS IS” AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.freqlabs.magic8ball

import com.amazon.speech.slu.Intent
import com.amazon.speech.speechlet.{
  IntentRequest,
  LaunchRequest,
  Session,
  SessionEndedRequest,
  SessionStartedRequest,
  Speechlet,
  SpeechletRequest,
  SpeechletResponse
}
import com.amazon.speech.ui.PlainTextOutputSpeech

class Magic8BallSpeechlet extends Speechlet {
  import Magic8BallSpeechlet._

  override def onSessionStarted(request: SessionStartedRequest, session: Session): Unit = {
    logInvocation("onSessionStarted", request, session)
  }

  override def onLaunch(request: LaunchRequest, session: Session): SpeechletResponse = {
    logInvocation("onLaunch", request, session)

    val outputSpeech = new PlainTextOutputSpeech
    outputSpeech.setText("What do you want to know?")

    SpeechletResponse.newTellResponse(outputSpeech)
  }

  override def onIntent(request: IntentRequest, session: Session): SpeechletResponse = {
    logInvocation("onIntent", request, session)

    val answer = Magic8Ball.ask()

    val outputSpeech = new PlainTextOutputSpeech
    outputSpeech.setText(answer)

    val response = SpeechletResponse.newTellResponse(outputSpeech)
    response.setShouldEndSession(true)

    response
  }

  override def onSessionEnded(request: SessionEndedRequest, session: Session): Unit = {
    logInvocation("onSessionEnded", request, session)
  }
}

object Magic8BallSpeechlet {
  private def logInvocation(name: String, request: SpeechletRequest, session: Session): Unit = {
    val requestId = request.getRequestId
    val sessionId = session.getSessionId
    println(s"$name requestId=$requestId sessionId=$sessionId")
  }
}
