package com.example.domain

import com.akkaserverless.scalasdk.valueentity.ValueEntity
import com.akkaserverless.scalasdk.valueentity.ValueEntityContext
import com.example
import com.google.protobuf.empty.Empty

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

/** A value entity. */
class UserPresence(context: ValueEntityContext) extends AbstractUserPresence {
  override def emptyState: UserPresenceState = UserPresenceState()

  override def togglePresence(currentState: UserPresenceState, togglePresenceCommand: example.TogglePresenceCommand): ValueEntity.Effect[Empty] = {
    val newState = currentState.copy(isOnline = togglePresenceCommand.isOnline) 
    effects
      .updateState(newState) 
      .thenReply(Empty.defaultInstance) 
  }

  override def getCurrentUserPresence(currentState: UserPresenceState, getUserPresenceCommand: example.GetUserPresenceCommand): ValueEntity.Effect[UserPresenceState] = {
    effects.reply(currentState) 
  }

}

