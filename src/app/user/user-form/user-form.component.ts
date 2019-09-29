import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formbuilder: FormBuilder) { }

  ngOnInit() {

    this.form = this.formbuilder.group({
      name: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(20)]]
    });
  }

}
