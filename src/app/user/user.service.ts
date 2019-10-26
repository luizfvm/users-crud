import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "./user";
import { take } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class UserService {
  private readonly API = "/api/users";

  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get<User[]>(this.API);
  }

  insert(user) {
    return this.http.post(this.API, user).pipe(take(1));
  }

  delete(id) {
    return this.http.delete(`${this.API}/${id}`).pipe(take(1));
  }

  update(user) {
    return this.http.put(`${this.API}/${user.id}`, user).pipe(take(1));
  }

  save(user) {
    if (user.id) {
      return this.update(user);
    }
    return this.insert(user);
  }
}
