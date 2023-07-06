package pl.nazwa.server873539.index

import kotlinx.html.*
import pl.nazwa.server873539.data.model.KMMAppData

class Index() {

    fun indexHtml(apsData: List<KMMAppData>) : HTML.() -> Unit {



         return {
             body {
                 style = "margin: 0px; font-family: Arial, Helvetica, sans-serif; font-size:24px"
                 div() {
                     style = "width:100%; margin: 0px; text-align: center; display: flex; flex-direction: column; justify-content: center; align-items: center"
                     div() {
                         style = "text-align: left; width: 100%; max-width: 1000px; height 80px;  font-size: 60px; padding-left: 60px; font-weight: bold;"
                         p { text("> arturlasok.com")}
                     }
                     apsData.onEach { apka ->
                         val platform = listOf(Pair(apka.mAppStoreLinkAndroid,"Android"), Pair(apka.mAppStoreLinkIOS,"iOS"),Pair(apka.mAppStoreLinkWeb,"Web"))
                         val platformString = platform.joinToString {
                             if(it.first.isNotEmpty())  it.second else ""  }.substringBefore(", ,")
                         div() {
                             style = "text-align: center; width: 100%; max-width: 1000px; height: auto;display: flex; flex-direction: row; flex-wrap: wrap;  justify-content: center; "

                             div() {
                                 style =
                                     "text-align: left; width: 45%; height:100%; "
                                 div()
                                 {
                                     style = "height:64px; display: flex; flex-direction: row; flex-wrap: nowrap;  justify-content: left; align-items:center "
                                     img(alt = "LOGO",
                                         src = apka.mIconLink.replace("http", "https")
                                             .replace("server873539.nazwa.pl", "arturlasok.com")
                                     ) {
                                         style = "width: 64px; height: 64px; padding-right: 10px"
                                     }
                                     p {
                                         style= "font-weight: bold;"
                                             a(href = apka.mAppStoreLinkAndroid, target = "_blank") {
                                                 style="color: black"
                                                 text(apka.mAppNamePL )
                                             }
                                          }
                                 }

                                 p { text(apka.mAppDescPL ) }

                                 p {
                                     style= "font-weight: bold;"
                                     text("Platform" ) }

                                 p { text(platformString) }

                                 p {
                                     style= "font-weight: bold;"
                                     text("Tech stack" ) }

                                 p { text(apka.mTechStack ) }


                             }
                             div {
                                 style = "text-align: center; width: 45%;"
                                 a(href = apka.mAppStoreLinkAndroid, target = "_blank") {
                                     style = "color: black"
                                     img(
                                         alt = "LOGO",
                                         src = apka.mPhotoLink.replace("http", "https")
                                             .replace("server873539.nazwa.pl", "arturlasok.com")
                                     ) {
                                         style = "width: 100%; max-width:350px; height: auto; object-fit: cover; "
                                     }
                                 }
                             }

                         }
                     }
                 }

            }

         }

    }



}