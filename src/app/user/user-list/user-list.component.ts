import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../curso';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss'],
  preserveWhitespaces: true
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private service: UserService) { }

  ngOnInit() {
    this.service.list().subscribe(userlist => this.users = userlist);
  }

}
