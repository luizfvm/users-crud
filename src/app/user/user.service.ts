import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './curso';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API = 'http://localhost:8080/users';

  constructor(private http: HttpClient) { }

list() {
  return this.http.get<User[]>(this.API)
  .pipe(tap(console.log));
}

}
