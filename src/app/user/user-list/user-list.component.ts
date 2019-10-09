import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { User } from "../user";
import { Observable } from "rxjs";


@Component({
  selector: "app-user-list",
  templateUrl: "./user-list.component.html",
  styleUrls: ["./user-list.component.scss"],
  preserveWhitespaces: true
})
export class UserListComponent implements OnInit {
  users$: Observable<User[]>;

  constructor(
    private service: UserService,
  ) {}

  ngOnInit() {
    this.users$ = this.service.list();
  }
}
