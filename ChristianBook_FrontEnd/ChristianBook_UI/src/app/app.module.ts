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
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { FormsModule } from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';

 import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthGuard } from './_auth/auth.guard';
import { UserService } from './services/user.service';
import { BrowserAnimationsModule, provideAnimations } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RouterModule } from '@angular/router';



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
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule, 
    MatCardModule,
    MatTableModule,
    MatIconModule,
    MatDialogModule,
    MatButtonModule
  
  


  ],
  providers: [

    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService,
    provideAnimations()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
