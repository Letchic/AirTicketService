import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightComponent } from './shared/flight/flight.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {LoginPageComponent} from './shared/login-page/login-page.component';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './shared/home/home.component';
import {RegisterPageComponent} from './shared/register-page/register-page.component';
import { MenuComponent } from './shared/menu/menu.component';
import {Globals} from './shared/Globals';
import { AccountPageComponent } from './shared/account-page/account-page.component';
import { PurchasePageComponent } from './shared/purchase-page/purchase-page.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ReturnComponent } from './shared/return/return.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminPageComponent } from './shared/admin-page/admin-page.component';
import { AlreadybuyedComponent } from './shared/alreadybuyed/alreadybuyed.component';
import { SupportchatPageComponent } from './shared/supportchat-page/supportchat-page.component';



const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login-page', component: LoginPageComponent},
  {path: 'register-page', component: RegisterPageComponent},
  {path: 'account-page', component: AccountPageComponent},
  {path: 'parchase-page', component: PurchasePageComponent},
  {path: 'app-return', component: ReturnComponent},
  {path: 'admin-page', component: AdminPageComponent},
  {path: 'app-alreadybuyed', component: AlreadybuyedComponent},
  {path: 'support-page', component: SupportchatPageComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    FlightComponent,
    LoginPageComponent,
    HomeComponent,
    RegisterPageComponent,
    MenuComponent,
    AccountPageComponent,
    PurchasePageComponent,
    FooterComponent,
    ReturnComponent,
    AdminPageComponent,
    AlreadybuyedComponent,
    SupportchatPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    NgbModule,
    ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule { }
