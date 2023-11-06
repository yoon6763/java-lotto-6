package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.models.Lotto;
import lotto.models.WinningNumber;
import lotto.valid.StringValidator;

import java.util.List;

public class InputView {

    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseMoney() {
        while (true) {
            System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
            String input = Console.readLine();

            try {
                int purchaseMoney = StringValidator.purchaseValidate(input);
                return purchaseMoney;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumber inputWinningNumber() {
        Lotto lotto = inputLottoWinningNumber();
        WinningNumber winningNumber = inputBonusNumber(lotto);
        return winningNumber;
    }


    private static Lotto inputLottoWinningNumber() {
        while (true) {
            System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
            try {
                List<Integer> lottoNumbers = StringValidator.lottoValidate(Console.readLine());
                Lotto lotto = new Lotto(lottoNumbers);
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static WinningNumber inputBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            try {
                int bonusNumber = StringValidator.bonusNumberValidate(Console.readLine());
                return new WinningNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
