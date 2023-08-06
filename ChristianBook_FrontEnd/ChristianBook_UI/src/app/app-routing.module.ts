import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { ShowDocumentDetailsComponent } from './show-document-details/show-document-details.component';
import { AddNewDocumentComponent } from './add-new-document/add-new-document.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AuthGuard } from './_auth/auth.guard';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path:'signUp', component:SignUpComponent },
  {path: 'login',component: LoginComponent},
  {path: 'user', component:UserComponent,canActivate:[AuthGuard],data:{roles:['User']}},
  {path:'admin',component:AdminComponent,canActivate:[AuthGuard],data:{roles:['Admin']}},
  {path: 'addNewDoc', component:AddNewDocumentComponent},
  {path:'showDocDetails',component:ShowDocumentDetailsComponent},
  {path:'forbidden',component:ForbiddenComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
