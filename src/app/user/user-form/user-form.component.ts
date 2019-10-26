import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { UserService } from "../user.service";
import { Location } from "@angular/common";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-user-form",
  templateUrl: "./user-form.component.html",
  styleUrls: ["./user-form.component.scss"]
})
export class UserFormComponent implements OnInit {
  form: FormGroup;
  submitted = false;

  constructor(
    private formbuilder: FormBuilder,
    private userService: UserService,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    this.form = this.formbuilder.group({
      id: [id],
      name: [
        "",
        [Validators.required, Validators.minLength(4), Validators.maxLength(20)]
      ],
      email: ["", [Validators.required, Validators.email]]
    });
  }

  formError(field: string) {
    return this.form.get(field).errors;
  }

  onSubmit() {
    this.submitted = true;

    if (this.form.valid)
      this.userService.save(this.form.value).subscribe(success => {
        this.location.back();
      });
  }
}
