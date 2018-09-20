import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { InputWithValidationMsgComponent } from './input-with-validation-msg/input-with-validation-msg.component';


@NgModule({
  declarations: [
    AppComponent,
    InputWithValidationMsgComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
