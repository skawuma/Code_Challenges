import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
 import { MatToolbarModule } from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatInputModule } from '@angular/material/input';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AddNewDocumentComponent } from './add-new-document/add-new-document.component';
import { ShowDocumentDetailsComponent } from './show-document-details/show-document-details.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignUpComponent,
    HeaderComponent,
    ForbiddenComponent,
    AddNewDocumentComponent,
    ShowDocumentDetailsComponent,
    HomeComponent,
    UserComponent,
    AdminComponent
  ],
  imports: [
   BrowserModule,
  AppRoutingModule,
  MatToolbarModule,
  MatInputModule 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
