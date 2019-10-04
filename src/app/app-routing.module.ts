import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user/user-list/user-list.component';
import { AboutTextComponent } from './about/about-text/about-text.component';


const routes: Routes = [
  {
   path: '', pathMatch: 'full', redirectTo: 'users'
  },
  { 
    path: 'users', loadChildren: './user/user.module#UserModule'
  },
  {
    path: 'about', loadChildren: './about/about.module#AboutModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
