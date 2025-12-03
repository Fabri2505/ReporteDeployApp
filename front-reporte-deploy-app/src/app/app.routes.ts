import { Routes } from '@angular/router';
import { MainLayout } from './share/ui/main-layout/main-layout';

export const routes: Routes = [
    {
        path: '',
        component: MainLayout,
        children:[
            {
                path:'reporte',
                loadChildren: () => import('./report/reporte.routes').then(m => m.routes)
            }
        ]
    },
    {
        path: 'not-found',
        loadComponent: () => import('./share/feature/not-found/not-found').then(m => m.NotFound)
    },
    {
        path: '**',
        redirectTo: 'not-found'
    }
];
