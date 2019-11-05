package helpers

import data.constants.App

object Utils {

  def getEnv(): String = sys.env.getOrElse(App.ENV_VARIABLE, App.DEFAULT_ENV)

}
