import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputWithValidationMsgComponent } from './input-with-validation-msg.component';

describe('InputWithValidationMsgComponent', () => {
  let component: InputWithValidationMsgComponent;
  let fixture: ComponentFixture<InputWithValidationMsgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputWithValidationMsgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputWithValidationMsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
