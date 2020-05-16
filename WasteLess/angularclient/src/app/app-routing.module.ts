import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {GrocerylistComponent} from "./component/grocerylist/grocerylist.component";
import {GrocerylistitemComponent} from "./component/grocerylistitem/grocerylistitem.component";
import {UserFormComponent} from "./form/user-form/user-form.component";
import {ReportComponent} from "./component/report/report.component";

const routes: Routes = [
  {path: 'groceryLists-user', component: GrocerylistComponent},
  {path: 'groceryLists-user/:listId', component: GrocerylistitemComponent},
  {path: 'login', component: UserFormComponent},
  {path: 'reportGenerate', component: ReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
