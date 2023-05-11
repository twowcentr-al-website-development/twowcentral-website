import csstype.*
import dataclasses.Tool
import react.FC
import react.Props
import emotion.react.css
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react.useState

val tools = arrayOf(
    Tool(
        "https://docs.google.com/spreadsheets/d/1HS7-z5dVYmVvIGmLHuCplg915d1NMZmWjPUfzDLE_yA/edit?usp=sharing",
        "none",
        "Ero's Auto-Voting Maker",
        "Ero"
    ),
    Tool(
        "https://docs.google.com/spreadsheets/d/1dsQfHEFlsavSAyKRqWKzMVj6RGg4NA-Zok3SEI7m98A/edit?usp=sharing",
        "https://cdn.discordapp.com/attachments/481534942279630856/1106345561407365280/L32NFtz.png",
        "Pepsi's Automatic Voting Maker",
        "pepsi"
    ),
    Tool(
        "https://docs.google.com/spreadsheets/d/1qPIiCt6IQsa5yt88S22vEMt0t3WfvfRgpmNeBiowSL8/edit?usp=sharing",
        "none",
        "TWOWculator",
        "the MTWOW Engineering Team"
    )
)


external interface WelcomeProps : Props {
    var name: String
}


val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    div {
        css {
            marginTop = (-10).px
            marginLeft = (-10).px
            marginRight = (-10).px
            padding = 10.px
            backgroundColor = rgb(31, 31, 56)
            color = rgb(255, 255, 255)
            height = 40.px
        }
        div {
            css {
                float = Float.right
                fontSize = 16.px
                marginLeft = 10.px
                marginRight = 20.px
                fontWeight = FontWeight.bold
                verticalAlign = VerticalAlign.middle
                top = 50.pct
                transform = translatey(50.pct)
            }
            +"Hello, $name!"
        }
        div {
            css {
                float = Float.left
                fontSize = 32.px
                marginLeft = 10.px
                marginRight = 20.px
                fontWeight = FontWeight.bolder
                verticalAlign = VerticalAlign.middle
            }
            +"Tools"
        }
        img {
            css {
                float = Float.right
                borderRadius = 4.px
            }
            src = "https://mcrenderer.onrender.com/display/generator?x=40&y=40&color=255,255,255&text=User&fontsize=10"
            width = 40.0
            height = 40.0
        }
    }
    /*
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
    */
    // https://mcrenderer.onrender.com/display/generator?x=300&y=300&color=255,255,255&text=No%20image%20found!
    for (tool in tools) {
        div {
            onClick = {
                window.location.href = tool.url
            }
            css {
                overflow = Overflow.hidden
                outline = Outline(4.px, LineStyle.solid, rgb(31,31,31))
                margin = 20.px
                width = 600.px
                height = 350.px
                backgroundColor = rgb(31,31,31)
            }
            if (tool.imageUrl != "none") {
                img {
                    src = tool.imageUrl
                    alt = tool.title
                    width = 600.0
                    height = 300.0
                    }
            } else {
                img {
                    src = "https://mcrenderer.onrender.com/display/generator?x=600&y=300&color=255,255,255&text=No%20image%20found!&fontsize=40"
                    alt = "Placeholder"
                    width = 600.0
                    height = 300.0
                }
            }
            div {
                css {
                    float = Float.left
                    fontWeight = FontWeight.bolder
                    color = rgb(255, 255, 255)
                    fontSize = 36.px
                }
                + tool.title
            }
            div {
                css {
                    float = Float.right
                    fontWeight = FontWeight.bolder
                    color = rgb(200, 200, 200)
                    fontSize = 18.px
                    marginTop = 20.px
                }
                + "by ${tool.creator}"
            }
        }
    }
}