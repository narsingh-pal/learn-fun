import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-with-validation-msg',
  templateUrl: './input-with-validation-msg.component.html',
  styleUrls: ['./input-with-validation-msg.component.css']
})
export class InputWithValidationMsgComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  message:string;

  handleChange($event){
    console.log("input changed");
    this.message="input changed";
  }

}
