import helpers.Utils

object Start extends App {

  val env = Utils.getEnv()
  val session = Session(env)
  Application(env, session)

}
