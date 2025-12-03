import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadChildren: () => import('./report/reporte.routes').then(m => m.routes)
    },
    {
        path: 'prueba',
        loadComponent: () => import('./share/ui/main-layout/main-layout').then(m => m.MainLayout)
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
