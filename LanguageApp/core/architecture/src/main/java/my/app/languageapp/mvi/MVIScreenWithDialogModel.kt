package my.app.core.architecture.mvi

import my.app.core.architecture.mvi.models.DialogStateModel
import my.app.core.architecture.mvi.models.MVIConfiguration
import my.app.core.architecture.mvi.models.dialogStateModel


@Suppress("UnnecessaryAbstractClass")
abstract class MVIScreenWithDialogModel<E, S, A, D>(
    config: MVIConfiguration<S>
) : MVIScreenModel<E, S, A>(config),
    DialogStateModel<D?> by dialogStateModel()
