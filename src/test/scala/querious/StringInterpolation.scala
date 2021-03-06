package querious

object StringInterpolation extends App {
  implicit class EscapeNewLineAndDoubleQuote(val sc: StringContext) extends AnyVal {
    def esc(args: Any*): String = {

      val strings = sc.parts.iterator
      val expression = args.iterator

      val builder = new StringBuilder(strings.next)
      while (strings.hasNext) {
        builder.append(
          expression.next.toString
            .replaceAllLiterally("\n", "\\n")
            .replaceAllLiterally("\r", "\\r")
            .replaceAllLiterally("\t", "\\t")
            .replaceAllLiterally("\"", """\"""")
            .replaceAllLiterally("\b", "\\b")
            .replaceAllLiterally("\f", "\\f")
        )
        builder.append(strings.next)
      }
      builder.toString
    }
  }

}