import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {UserFormComponent} from './form/user-form/user-form.component';
import {UserService} from './service/user-service.service';
import {GrocerylistComponent} from './component/grocerylist/grocerylist.component';
import {GrocerylistService} from "./service/grocerylist.service";
import {GrocerylistitemComponent} from './component/grocerylistitem/grocerylistitem.component';
import {GrocerylistitemService} from "./service/grocerylistitem.service";
import {GoalService} from "./service/goal.service";
import { ReportComponent } from './component/report/report.component';
import {ReportService} from "./service/report.service";
import {NotificationService} from "./service/notification.service";

@NgModule({
  declarations: [
    AppComponent,
    GrocerylistComponent,
    GrocerylistitemComponent,
    ReportComponent,
    UserFormComponent,
    ReportComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [GrocerylistService, GrocerylistitemService, UserService, GoalService, ReportService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
