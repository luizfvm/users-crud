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
  formGroup: FormGroup;
  submitted = false;
  formTitle = "";

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get("id");

    this.formGroup = this.formBuilder.group({
      id: [id],
      name: [
        "",
        [Validators.required, Validators.minLength(4), Validators.maxLength(20)]
      ],
      email: ["", [Validators.required, Validators.email]]
    });

    this.formGroup.value.id
      ? (this.formTitle = "Update user: " + id)
      : (this.formTitle = "Create a new user");
  }

  formError(field: string) {
    return this.formGroup.get(field).errors;
  }

  onSubmit() {
    this.submitted = true;

    if (this.formGroup.valid)
      this.userService.save(this.formGroup.value).subscribe(success => {
        this.location.back();
      });
  }
}
