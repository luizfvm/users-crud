import { Component, OnInit, ViewChild } from "@angular/core";
import { UserService } from "../user.service";
import { User } from "../user";
import { Observable } from "rxjs";
import { BsModalService, BsModalRef } from "ngx-bootstrap/modal";
import { Router, ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-user-list",
  templateUrl: "./user-list.component.html",
  styleUrls: ["./user-list.component.scss"],
  preserveWhitespaces: true
})
export class UserListComponent implements OnInit {
  users$: Observable<User[]>;
  deleteModalRef: BsModalRef;
  @ViewChild("deleteModal", { static: true }) deleteModal;
  selectedUser: User;

  constructor(
    private userService: UserService,
    private modalService: BsModalService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.users$ = this.userService.findAll();
  }

  onDelete(user) {
    this.selectedUser = user;
    this.deleteModalRef = this.modalService.show(this.deleteModal, {
      class: "modal-sm"
    });
  }

  onConfirm() {
    this.userService.delete(this.selectedUser.id).subscribe(success => {
      this.users$ = this.userService.findAll();
      this.deleteModalRef.hide();
    });
  }

  onDecline() {
    this.deleteModalRef.hide();
  }

  onUpdate(id) {
    this.router.navigate(["update", id], { relativeTo: this.route });
  }
}
